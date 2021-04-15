import React from 'react';
import 'date-fns';
import { Card, CardHeader, TextField, MenuItem, CardContent, Grid } from '@material-ui/core';
import { MuiPickersUtilsProvider, KeyboardDatePicker } from '@material-ui/pickers';
import DateFnsUtils from '@date-io/date-fns';
import { makeStyles } from '@material-ui/core/styles';
import MasterDataService from '../../services/MasterDataService';
import ExistingPositionPanel from '../ExistingPositionPanel';

const lookupDataService = new MasterDataService();
const posType = lookupDataService.fetchPositionType();
let isLoaded = false;

const useStyles = makeStyles(theme => ({
    menu: {
		width: 200,
	},
	section: {
		marginRight: theme.spacing(1),
		marginBottom: theme.spacing(1),
    },
    textField: {
		marginLeft: theme.spacing(1),
		marginRight: theme.spacing(1),
		width: 200,
	}
}));


export default function PositionPanel(props) {

    const classes = useStyles();
    const [locations, setLocations] = React.useState([]);

    if(!isLoaded){
        lookupDataService.fetchLocation(setLocations);
        isLoaded = true;
    }
    return (
        <Card className={classes.section}>
            <CardHeader title='Position Details' />
            <CardContent>
                <Grid container>
                    <Grid item xs={12}>
                        <MuiPickersUtilsProvider utils={DateFnsUtils}>
                            <KeyboardDatePicker
                                margin="normal"
                                id="startDate"
                                label="Planned starting date"
                                format="MM/dd/yyyy"
                                value={props.requisition.date}
                                onChange={props.handleStartDateChange}
                                KeyboardButtonProps={{
                                    'aria-label': 'change date',
                                }}
                                disabled={props.disabled}
                            />
                        </MuiPickersUtilsProvider>
                        <TextField
                            id="location"
                            select
                            label="Location"
                            className={classes.textField}
                            value={props.requisition.location}
                            onChange={props.handleLocationChange}
                            SelectProps={{
                                MenuProps: {
                                    className: classes.menu,
                                },
                            }}
                            margin="normal"
                            disabled={props.disabled}
                        >
                            {locations.map(option => (
                                <MenuItem key={option.value} value={option.value}>
                                    {option.label}
                                </MenuItem>
                            ))}
                        </TextField>

                        <TextField
                            id="posType"
                            select
                            label="Position Type"
                            className={classes.textField}
                            value={props.position.positionType}
                            onChange={props.handlePositionChange}
                            SelectProps={{
                                MenuProps: {
                                    className: classes.menu,
                                },
                            }}
                            margin="normal"
                            disabled={props.disabled}
                        >
                            {posType.map(option => (
                                <MenuItem key={option.value} value={option.value}>
                                    {option.label}
                                </MenuItem>
                            ))}
                        </TextField>

                        <TextField
                            id="jobTitle"
                            label="Job Title"
                            value={props.position.jobTitle}
                            onChange={props.handleJobTitleChange}
                            type="text"
                            className={classes.textField}
                            InputLabelProps={{
                                shrink: true,
                            }}
                            margin="normal"
                            disabled={props.disabled}
                        />
                    </Grid>
                    {props.position.positionType === 'e' &&
                        (<Grid item xs={12}>
                                <ExistingPositionPanel disabled={props.disabled} replacement={props.position.replacement}/>
                        </Grid>)
                    }
                </Grid> 
                
            </CardContent>
        </Card>
    );
}