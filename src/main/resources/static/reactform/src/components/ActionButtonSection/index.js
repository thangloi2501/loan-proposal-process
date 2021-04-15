import React from 'react';
import { makeStyles, Grid, Button } from '@material-ui/core';
import CheckIcon from '@material-ui/icons/Check';
import SaveIcon from '@material-ui/icons/Save';
import CancelIcon from '@material-ui/icons/Cancel';

const useStyle = makeStyles( theme => ({
    button: {
		margin: theme.spacing(1),
	}
}));

export default function ActionButtonSection(props){

    const classes = useStyle();
    return(
        <Grid container justify="center">
            <Grid item>
                <Button
                    variant="contained"
                    color="primary"
                    className={classes.button}
                    onClick={props.handleSubmitClick}
                    startIcon={<CheckIcon></CheckIcon>}>
                    Submit
                </Button>
                <Button
                    variant="contained"
                    color="default"
                    className={classes.button}
                    startIcon={<SaveIcon></SaveIcon>}
                    onClick={props.handleSaveClick}
                >
                    Save
                </Button>
                <Button
                    variant="contained"
                    color="default"
                    className={classes.button}
                    startIcon={<CancelIcon></CancelIcon>}
                    onClick={props.handleCancelClick}
                >
                    Cancel
                </Button>
            </Grid>
        </Grid>
    );
}