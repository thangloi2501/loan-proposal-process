import React from 'react';
import { ExpansionPanel, ExpansionPanelSummary, ExpansionPanelDetails, Typography, Card, Grid, Button } from '@material-ui/core';
import CustomerPanel from '../../components/CustomerPanel';
import PositionPanel from '../../components/PositionPanel';
import QualificationPanel from '../../components/QualificationPanel';
import ApprovalPanel from '../../components/ApprovalPanel';
import CheckIcon from '@material-ui/icons/Check';
import SaveIcon from '@material-ui/icons/Save';
import CancelIcon from '@material-ui/icons/Cancel';
import { makeStyles } from '@material-ui/core/styles';
import ActionButtonSection from '../../components/ActionButtonSection';

const useStyle = makeStyles(theme => ({
	button:{
		margin: theme.spacing(1),
	}
}))

function GMReviewApplicationHook(props){

	const classes = useStyle();

    return(
		<div>
			<ExpansionPanel expanded>
				<ExpansionPanelSummary>
					<Typography>New position approval</Typography>
				</ExpansionPanelSummary>
				<ExpansionPanelDetails>
					<Grid container direction="row">
						<Grid item xs={12} lg={6}>
							<CustomerPanel disabled={true} requisition={props.requisition}

							/>
						</Grid>
						<Grid item xs={12} lg={6}>
							<PositionPanel  position = {props.position}
											requisition = {props.requisition}
											disabled={true}

							/>
						</Grid>
						<Grid item xs={12}>
							<QualificationPanel qualification={props.qualification} disabled={true}

							/>
						</Grid>
						<Grid item xs={12}>
							<ApprovalPanel  gmApproval={props.requisition.gmApproval}
											gmComment={props.requisition.gmComments}
											handlerGMCommentChange={props.handlerGMCommentChange}
											handleApprovalSelect={props.handleApprovalSelect}
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

export default class Control1Approval extends React.Component{

    constructor(props){
        super(props);
        console.log("props: ", props);
		this.backUrl = props.backUrl;
        this.state = {
            taskId: props.taskId,
            isLoaded: false,
            requisition: {},
            position: {},
            qualification: {}
        }
        this.handlerGMCommentChange = this.handlerGMCommentChange.bind(this);
        this.handleApprovalSelect = this.handleApprovalSelect.bind(this);

        this.handleCancelClick 			= 	this.handleCancelClick.bind(this);
		this.handleSaveClick 			= 	this.handleSaveClick.bind(this);
		this.handleSubmitClick 			= 	this.handleSubmitClick.bind(this);
    }

    componentDidMount() {
        const host = `${window.location.protocol + '//' + window.location.host}`;
		fetch(`${host}/rest/task/${this.state.taskId}/variables`,{
                mode:'no-cors',
                headers: {
                    "Content-type": "application/json; charset=UTF-8"
                }
            })
			.then(res => res.json())
			.then(
				(result) => {
					console.log("result: ", result);
					const requisition = result.requisition ? result.requisition : {value: { empType: "", department: "", location: "" }};
					console.log("After parsing requisition: ", requisition);
					const position = result.position ? result.position : {value:{ positionType: "", replacement: {} }};
					console.log("After parsing position: ", position);
					const qualification = result.qualification ? result.qualification : {value: {educations:[], skills:[], experience: "l0"}};
                    console.log("After parsing qualification: ", qualification);

					this.setState({
						isLoaded: true,
						requisition: requisition,
						position: position,
						qualification: qualification
					});
				},
				(error) => {
					this.setState({
						isLoaded: false,
						error
					});
					console.log("Error: ", error);

				}
			)
	}

    handlerGMCommentChange(event){
        const requisition = this.state.requisition;
        requisition.value.gmComments = event.target.value;
        this.setState(
            {
                requisition: requisition
            }
        )
    }

    handleApprovalSelect(checked){
        console.log("Approval selected:", checked)
        const requisition = this.state.requisition;
        requisition.value.gmApproval = checked;
        this.setState(
            {
                requisition: requisition
            }
        )
    }

    handleCancelClick() {
		window.location.replace(this.backUrl)
	}

	handleSubmitClick(event) {
		console.log("requisition: ", this.state.requisition);
		const requisition = this.state.requisition;
		requisition.value = JSON.stringify(requisition.value);

		fetch(`${window.location.protocol + '//' + window.location.host}/rest/task/${this.state.taskId}/complete`, {
			method: 'POST',
			body: JSON.stringify({
				"variables": {
					"requisition": requisition
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
		requisition.value = JSON.stringify(requisition.value);
		console.log("requisition:", requisition);
		fetch(`${window.location.protocol + '//' + window.location.host}/rest/task/${this.state.taskId}/localVariables`, {
			method: 'POST',
			body: JSON.stringify({
				"modifications": {
					"requisition": requisition
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

    render(){
        if(this.state.isLoaded){
            return(
                <GMReviewApplicationHook    requisition             =   {this.state.requisition.value}
                                            position                =   {this.state.position.value}
                                            qualification           =   {this.state.qualification.value}
                                            handlerGMCommentChange  =   {this.handlerGMCommentChange}
                                            handleApprovalSelect    =   {this.handleApprovalSelect}
                                            handleCancelClick       =   {this.handleCancelClick}
                                            handleSubmitClick       =   {this.handleSubmitClick}
                                            handleSaveClick         =   {this.handleSaveClick}
    
                />
            );
        }
        else{
            return(
                <div>Loading...</div>
            );
        }
    }
}