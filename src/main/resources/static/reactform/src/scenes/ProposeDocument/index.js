import React from 'react';
import LoanPanel from '../../components/LoanPanel';
import CustomerPanel from '../../components/CustomerPanel';
import { ExpansionPanel, Typography, Grid, Button, ExpansionPanelSummary, ExpansionPanelDetails} from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import ActionButtonSection from '../../components/ActionButtonSection';


const useStyles = makeStyles(theme => ({
	root: {
		width: '100%',
	},
	heading: {
		fontSize: theme.typography.pxToRem(15),
		fontWeight: theme.typography.fontWeightBold,
	},
	label: {
		marginLeft: theme.spacing(1),
		marginRight: theme.spacing(1)
	},
	button: {
		margin: theme.spacing(1),
	},
}));

function ProposeDocumentHook(props) {

	const classes = useStyles();
	return (
		<div>
			<ExpansionPanel expanded>
				<ExpansionPanelSummary
					aria-controls="panel1a-content"
					id="panel1a-header">
					<Typography className={classes.heading}>Loan Credit Proposal</Typography>
                </ExpansionPanelSummary>

				<ExpansionPanelDetails>
                    <Grid container>
                        <Grid item xs={12}>
							<Typography className={classes.label}>Proposal ID: {props.proposalId}</Typography>
							<Typography className={classes.label}>Proposal Time: {props.proposalDateTime}</Typography>
						</Grid>

                        <Grid item xs={12} lg={6}>
                            <CustomerPanel  customer             			=   {props.customer} 
                                            handleCustomerCodeChange   		=   {props.handleCustomerCodeChange}
                                            handleCustomerNameChange   		=   {props.handleCustomerNameChange}
                                            handleCustomerPhoneNumberChange =   {props.handleCustomerPhoneNumberChange}
                                            handleCustomerAddressChange		=   {props.handleCustomerAddressChange} 
											handleCustomerTypeSelect		=	{props.handleCustomerTypeSelect}
											disabled={false}
											/>
                        </Grid>
                        <Grid item xs={12} lg={6}>
                            <LoanPanel  	loan             				=   {props.loan} 
                                            handleLoanIdChange   			=   {props.handleLoanIdChange}
                                            handleLoanAmountChange    		=   {props.handleLoanAmountChange}
                                            handleLoanTermChange    		=   {props.handleLoanTermChange}
                                            handleLoanInterestRateChange    =   {props.handleLoanInterestRateChange} 
											handleLoanTypeSelect	   		=   {props.handleLoanTypeSelect} 											
											disabled={false}
											/>
                        </Grid>
                    </Grid>
				</ExpansionPanelDetails>
			</ExpansionPanel>

			<ActionButtonSection 	handleSubmitClick 	=	{props.handleSubmitClick}
									handleSaveClick		=	{props.handleSaveClick}
									handleCancelClick	=	{props.handleCancelClick}
			/>
		</div>
	);
}

export default class ProposeDocument extends React.Component{
    
    constructor(props){
        super(props)
        console.log("props: ", props);
		this.backUrl = props.backUrl;
        this.state = {
            taskId: props.taskId,
			proposalId: props.proposalId,
			proposalDateTime: props.proposalDateTime,
			isLoaded: false,
			customer: {value: { code: "", name: "", phoneNumber: "", address: "", type: "0"}},
			loan: {value: { id: "", amount: 0, term: 0, interestRate: 0.0, type: "0"}}
        };

		this.handleCustomerCodeChange 			= this.handleCustomerCodeChange.bind(this);
		this.handleCustomerNameChange 			= this.handleCustomerNameChange.bind(this);
		this.handleCustomerPhoneNumberChange 	= this.handleCustomerPhoneNumberChange.bind(this);
		this.handleCustomerAddressChange 		= this.handleCustomerAddressChange.bind(this);
		this.handleCustomerTypeSelect 			= this.handleCustomerTypeSelect.bind(this);

		this.handleLoanIdChange 				= this.handleLoanIdChange.bind(this);
		this.handleLoanAmountChange 			= this.handleLoanAmountChange.bind(this);
		this.handleLoanTermChange 				= this.handleLoanTermChange.bind(this);
		this.handleLoanInterestRateChange 		= this.handleLoanInterestRateChange.bind(this);
		this.handleLoanTypeSelect 				= this.handleLoanTypeSelect.bind(this);

		this.handleSubmitClick 	= this.handleSubmitClick.bind(this);
		this.handleCancelClick	= this.handleCancelClick.bind(this);
		this.handleSaveClick	= this.handleSaveClick.bind(this);
	}

	handleCustomerCodeChange(event) {
		const customer = this.state.customer;
		customer.value.code = event.target.value;
		this.setState(
			{ customer: customer }
		)
	}
	
	handleCustomerNameChange(event) {
		const customer = this.state.customer;
		customer.value.name = event.target.value;
		this.setState(
			{ customer: customer }
		)
	}
	
	handleCustomerPhoneNumberChange(event) {
		const customer = this.state.customer;
		customer.value.phoneNumber = event.target.value;
		this.setState(
			{ customer: customer }
		)
	}
	
	handleCustomerAddressChange(event) {
		const customer = this.state.customer;
		customer.value.address = event.target.value;
		this.setState(
			{ customer: customer }
		)
	}

	handleCustomerTypeSelect(checked){
		const customer = this.state.customer;
		customer.value.type = checked;
		this.setState({
			customer: customer
		})
	}

	// ----------------------------	
	handleLoanIdChange(event) {
		const loan = this.state.loan;
		loan.value.id = event.target.value;
		this.setState(
			{ loan: loan }
		)
	}

	handleLoanAmountChange(event) {
		const loan = this.state.loan;
		loan.value.amount = event.target.value;
		this.setState(
			{ loan: loan }
		)
	}
	
	handleLoanTermChange(event) {
		const loan = this.state.loan;
		loan.value.term = event.target.value;
		this.setState(
			{ loan: loan }
		)
	}
	
	handleLoanInterestRateChange(event) {
		const loan = this.state.loan;
		loan.value.interestRate = event.target.value;
		this.setState(
			{ loan: loan }
		)
	}
	
	handleLoanTypeSelect(checked){
		const loan = this.state.loan;
		loan.value.type = checked;
		this.setState(
			{ loan: loan }
		)
	}

	// -----------------------------
	handleCancelClick() {
		window.location.replace(this.backUrl)
	}

	handleSubmitClick(event) {
		console.log("customer: ", this.state.customer);
		console.log("loan: ", this.state.loan);
		const proposalId = this.state.proposalId;
		const proposalDateTime = this.state.proposalDateTime;
		const customer = this.state.customer;
		const loan = this.state.loan;
		customer.value = JSON.stringify(loan.value);
		loan.value = JSON.stringify(loan.value);

		fetch(`${window.location.protocol + '//' + window.location.host}/rest/task/${this.state.taskId}/complete`, {
			method: 'POST',
			body: JSON.stringify({
				"variables": {
					"proposalId": proposalId,
					"proposalDateTime": proposalDateTime,
					"customer": customer,
					"loan": loan
				}
			}),
			headers: {
				"Content-type": "application/json; charset=UTF-8"
			}
		})
			.then(data => {
				if (data.status === 204) {
					alert("save successfully")
					window.location.replace(this.backUrl);
				} else {
					alert("error");
					console.log(data);
				}
			})

	}

	handleSaveClick() {
		const proposalId = this.state.proposalId;
		const proposalDateTime = this.state.proposalDateTime;
		const customer = this.state.customer;
		const loan = this.state.loan;
		customer.value = JSON.stringify(loan.value);
		loan.value = JSON.stringify(loan.value);
		fetch(`${window.location.protocol + '//' + window.location.host}/rest/task/${this.state.taskId}/localVariables`, {
			method: 'POST',
			body: JSON.stringify({
				"modifications": {
					"proposalId": proposalId,
					"proposalDateTime": proposalDateTime,
					"customer": customer,
					"loan": loan
				}
			}),
			headers: {
				"Content-type": "application/json; charset=UTF-8"
			}
		})
			.then(data => {
				if (data.status === 204) {
					alert("save successfully")
					window.location.replace(this.backUrl);
				} else {
					alert("error");
					console.log(data);
				}
			})
	}

	componentDidMount() {
		fetch(`${window.location.protocol + '//' + window.location.host}/rest/task/${this.state.taskId}/variables`)
			.then(res => res.json())
			.then(
				(result) => {
					console.log("result: ", result);
					const customer = result.customer ? result.customer : {value: { code: "", name: "", phoneNumber: "", address: "", type: "0"}};
					console.log("After parsing customer: ", customer);
					const loan = result.loan ? result.loan : {value:{ id: "", amount: 0, term: 0, interestRate: 0.0, type: "0"}};
					console.log("After parsing loan: ", loan);
					const proposalId = result.proposalId ? result.proposalId : "";
					const proposalDateTime = result.proposalDateTime ? result.proposalDateTime : "";

					this.setState({
						isLoaded: true,
						proposalId: proposalId,
						proposalDateTime: proposalDateTime,
						customer: customer,
						loan: loan
					});
				},
				(error) => {
					this.setState({
						isLoaded: true,
						error
					});
					console.log("Error: ", error);

				}
			)
	}

    render(){
        return(
			(this.state.isLoaded)?
					<ProposeDocumentHook  requisition				=	{this.state.requisition.value}
											position				=	{this.state.position.value}
											qualification			=	{this.state.qualification.value}

											handleEmpTypeChange		=	{this.handleEmpTypeChange}
											handleDepartmentChange	=	{this.handleDepartmentChange}
											handleLocationChange	=	{this.handleLocationChange}
											handlePositionChange	=	{this.handlePositionChange}
											handleEmpNumChange		=	{this.handleEmpNumChange}
											handleJobTitleChange	=	{this.handleJobTitleChange}
											handleStartDateChange	=	{this.handleStartDateChange}
											handleRequesterChange	=	{this.handleRequesterChange}
											handleCancelClick		=	{this.handleCancelClick}
											handleSaveClick			=	{this.handleSaveClick}
											handleSubmitClick		=	{this.handleSubmitClick}
											handleEducationSelect	= 	{this.handleEducationSelect}
											handleSkillSelect		= 	{this.handleSkillSelect}
											handleExperienceSelect	= 	{this.handleExperienceSelect}
											handleIsNewPositionClick=	{this.handleIsNewPositionClick}
					/>
			:<div>Loading....</div>
        );
    }
}