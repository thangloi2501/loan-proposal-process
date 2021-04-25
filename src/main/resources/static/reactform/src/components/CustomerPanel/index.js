import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Card, CardHeader, CardContent, TextField, MenuItem } from '@material-ui/core';
import MasterDataService from '../../services/MasterDataService';

const masterDataService = new MasterDataService();

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

export default function CustomerPanel(props) {

    const [customerTypes, setCustomerTypes] = React.useState([]);
    const classes = useStyles();
    if(!isLoaded){
        masterDataService.fetchCustomerType(setCustomerTypes);
        isLoaded = true;
    }

    return (
        <Card className={classes.section}>
            <CardHeader title='Customer' />
            <CardContent>

                <TextField
                    id="customerCode"
                    label="Customer Code"
                    className={classes.textField}
                    value={props.customer.code}
                    onChange={props.handleCustomerCodeChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="customerName"
                    label="Customer Name"
                    className={classes.textField}
                    value={props.customer.name}
                    onChange={props.handleCustomerNameChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="customerPhoneNumber"
                    label="Phone Number"
                    className={classes.textField}
                    value={props.customer.phoneNumber}
                    onChange={props.handleCustomerPhoneNumberChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="customerAddress"
                    label="Customer Address"
                    className={classes.textField}
                    value={props.customer.address}
                    onChange={props.handleCustomerAddressChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="customerType"
                    select
                    label="Customer type"
                    className={classes.textField}
                    value={props.customer.type}
                    onChange={props.handleCustomerTypeChange}
                    SelectProps={{
                        MenuProps: {
                            className: classes.menu,
                        },
                    }}
                    margin="normal"
                    disabled={props.disabled}
                >
                    {customerTypes.map(option => (
                        <MenuItem key={option.value} value={option.value}>
                            {option.label}
                        </MenuItem>
                    ))}
                </TextField>
            </CardContent>
        </Card>
    );
}