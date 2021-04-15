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
											handleCustomerTypeChange		=	{props.handleCustomerTypeChange}
											disabled={false}
											/>
                        </Grid>
                        <Grid item xs={12} lg={6}>
                            <LoanPanel  	loan             				=   {props.loan} 
                                            handleLoanIdChange   			=   {props.handleLoanIdChange}
                                            handleLoanAmountChange    		=   {props.handleLoanAmountChange}
                                            handleLoanTermChange    		=   {props.handleLoanTermChange}
                                            handleLoanInterestRateChange    =   {props.handleLoanInterestRateChange} 
											handleLoanTypeChange    		=   {props.handleLoanTypeChange} 											
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
			isLoaded: false,
			customer: {value: { code: "", name: "", phoneNumber: "", address: "", type: "0"}},
			loan: {value: { id: "", amount: 0, term: 0, interestRate: 0.0, type: "0"}}
        };

        this.handleCustomerCodeChange 	= 	this.handleCustomerCodeChange.bind(this);
		this.handleCustomerNameChange 	= 	this.handleCustomerNameChange.bind(this);
		this.handleCustomerPhoneNumberChange 		= 	this.handleCustomerPhoneNumberChange.bind(this);
		this.handleCustomerAddressChange 		= 	this.handleCustomerAddressChange.bind(this);
		this.handleCustomerTypeChange 		= 	this.handleCustomerTypeChange.bind(this);

		this.handleSubmitClick 			= 	this.handleSubmitClick.bind(this);
		this.handleEmpNumChange 		= 	this.handleEmpNumChange.bind(this);
		this.handleRequesterChange 		= 	this.handleRequesterChange.bind(this);
		this.handleJobTitleChange 		= 	this.handleJobTitleChange.bind(this);
		this.handleStartDateChange 		= 	this.handleStartDateChange.bind(this);
		this.handleCancelClick 			= 	this.handleCancelClick.bind(this);
		this.handleSaveClick 			= 	this.handleSaveClick.bind(this);
		this.handleSubmitClick 			= 	this.handleSubmitClick.bind(this);
		this.handleEducationSelect 		= 	this.handleEducationSelect.bind(this);
		this.handleSkillSelect 			= 	this.handleSkillSelect.bind(this);
		this.handleExperienceSelect		= 	this.handleExperienceSelect.bind(this);
	}

	handleEducationSelect(checked){
		const qualification = this.state.qualification;
		let educations = qualification.value.educations.slice();
		educations = checked;
		qualification.value.educations = educations;
		this.setState({
			qualification: qualification
		})
		
	}

	handleSkillSelect(checked){
		const qualification = this.state.qualification;
		qualification.value.skills = checked;
		this.setState({
			qualification: qualification
		})
	}

	handleExperienceSelect(checked){
		console.log("exp: ", checked);
		const qualification = this.state.qualification;
		qualification.value.experience = checked;
		this.setState({
			qualification: qualification
		})
	}

    handleEmpTypeChange(event) {
		const requisition = this.state.requisition;
		requisition.value.empType = event.target.value;
		this.setState(
			{ requisition: requisition }
		)
	}

	handleDepartmentChange(event) {
		const requisition = this.state.requisition;
		requisition.value.department = event.target.value;
		this.setState(
			{ requisition: requisition }
		)
	}

	handleLocationChange(event) {
		const requisition = this.state.requisition;
		requisition.value.location = event.target.value;
		this.setState(
			{ requisition: requisition }
		)
	}

	handlePositionChange(event) {
		const position = this.state.position;
		position.value.positionType = event.target.value;
		this.setState(
			{ position: position }
		)
	}

	handleEmpNumChange(event) {
		const requisition = this.state.requisition;
		requisition.value.empNum = event.target.value;
		this.setState(
			{ requisition: requisition }
		)
	}

	handleRequesterChange(event) {
		const requisition = this.state.requisition;
		requisition.value.requester = event.target.value;
		this.setState(
			{ requisition: requisition }
		)
	}

	handleJobTitleChange(event) {
		const position = this.state.position;
		position.value.jobTitle = event.target.value;
		this.setState(
			{ position: position }
		)
	}

	handleStartDateChange(date) {
		const requisition = this.state.requisition;
		requisition.value.date = date || null;
		this.setState(
			{ requisition: requisition }
		)
	};

	handleCancelClick() {
		window.location.replace(this.backUrl)
	}

	handleSubmitClick(event) {
		console.log("requisition: ", this.state.requisition);
		console.log("position: ", this.state.position);
		console.log("qualification: ", this.state.qualification);
		const requisition = this.state.requisition;
		const qualification = this.state.qualification;
		const position = this.state.position;
		requisition.value = JSON.stringify(requisition.value);
		qualification.value = JSON.stringify(qualification.value);
		position.value = JSON.stringify(position.value);

		fetch(`${window.location.protocol + '//' + window.location.host}/rest/task/${this.state.taskId}/complete`, {
			method: 'POST',
			body: JSON.stringify({
				"variables": {
					"requisition": requisition,
					"position": position,
					"qualification": qualification,
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
		const requisition = this.state.requisition;
		const qualification = this.state.qualification;
		const position = this.state.position;
		requisition.value = JSON.stringify(requisition.value);
		qualification.value = JSON.stringify(qualification.value);
		position.value = JSON.stringify(position.value);
		fetch(`${window.location.protocol + '//' + window.location.host}/rest/task/${this.state.taskId}/localVariables`, {
			method: 'POST',
			body: JSON.stringify({
				"modifications": {
					"requisition": requisition,
					"position": position,
					"qualification": qualification
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
					const requisition = result.requisition ? result.requisition : {value: { empType: "", department: "", location: "" }};
					console.log("After parsing requisition: ", requisition);
					const position = result.position ? result.position : {value:{ positionType: "", replacement: {} }};
					console.log("After parsing position: ", position);
					const qualification = result.qualification ? result.qualification : {value: {educations:[], skills:[], experience: "l0"}};

					this.setState({
						isLoaded: true,
						requisition: requisition,
						position: position,
						qualification: qualification
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