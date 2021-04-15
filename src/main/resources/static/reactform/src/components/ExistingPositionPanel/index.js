import React from 'react';
import { ExpansionPanel, ExpansionPanelSummary, Typography, ExpansionPanelDetails, TextField, TextareaAutosize, Grid } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';

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
    },
    areaField:{
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: '100%'
    }
}));

export default function ExistingPositionPanel(props) {

    const classes = useStyles();

    return (
        <ExpansionPanel className={classes.section} expanded>
            <ExpansionPanelSummary>
                <Typography className={classes.heading}> Existing Position Data </Typography>
            </ExpansionPanelSummary>
            <ExpansionPanelDetails>
                <Grid container>
                    <Grid item xs={12}>
                        <TextField
                            id="givenName"
                            label="Given Name"
                            className={classes.textField}
                            value={props.replacement.lastName}
                            onChange={props.handleLastNameChange}
                            margin="normal"
                            disabled={props.disabled}
                        />
                        <TextField
                            id="familyName"
                            label="Family Name"
                            className={classes.textField}
                            value={props.replacement.firstName}
                            onChange={props.handleFirstNameChange}
                            margin="normal"
                            disabled={props.disabled}
                        />
                        <TextField
                            id="supervisor"
                            label="Supervisor"
                            className={classes.textField}
                            value={props.replacement.supervisor}
                            onChange={props.handleSupervisorChange}
                            margin="normal"
                            disabled={props.disabled}
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <TextareaAutosize
                            id="comment"
                            rows={4}
                            label="Comment"
                            placeholder="Comment"
                            className={classes.areaField}
                            value={props.replacement.notes}
                            onChange={props.handleCommentChange}
                            disabled={props.disabled}
                        />
                    </Grid>
                </Grid>
            </ExpansionPanelDetails>
        </ExpansionPanel>
    );
}