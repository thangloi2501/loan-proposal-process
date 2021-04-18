import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Card, CardHeader, CardContent, TextField, MenuItem } from '@material-ui/core';
import MasterDataService from '../../services/MasterDataService';

const masterDataService = new MasterDataService();
// const loanType = masterDataService.fetchLoanType();
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


export default function LoanPanel(props) {

    const [loanTypes, setLoanTypes] = React.useState([]);
    const classes = useStyles();
    if(!isLoaded){
        masterDataService.fetchLoanType(setLoanTypes);
        isLoaded = true;
    }

    return (
        <Card className={classes.section}>
            <CardHeader title='Loan' />
            <CardContent>
                <TextField
                    id="loanId"
                    label="Loan ID"
                    className={classes.textField}
                    value={props.loan.id}
                    onChange={props.handleLoanIdChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="LoanAmount"
                    label="Amount (VND)"
                    className={classes.textField}
                    value={props.loan.amount}
                    onChange={props.handleLoanAmountChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="loanTerm"
                    label="Term (months)"
                    className={classes.textField}
                    value={props.loan.term}
                    onChange={props.handleLoanTermChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="loanInterestRate"
                    label="Interest rate"
                    className={classes.textField}
                    value={props.loan.interestRate}
                    onChange={props.handleLoanInterestRateChange}
                    margin="normal"
                    disabled={props.disabled}
                />

                <TextField
                    id="loanType"
                    select
                    label="Type"
                    className={classes.textField}
                    value={props.loan.type}
                    onChange={props.handleLoanTypeSelect}
                    SelectProps={{
                        MenuProps: {
                            className: classes.menu,
                        },
                    }}
                    margin="normal"
                    disabled={props.disabled}
                >
                    {loanTypes.map(option => (
                        <MenuItem key={option.value} value={option.value}>
                            {option.label}
                        </MenuItem>
                    ))}
                </TextField>
            </CardContent>
        </Card>
    );
}