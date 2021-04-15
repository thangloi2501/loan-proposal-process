import React from 'react';
import { Radio, List, TextField, ListItem, ListItemIcon, ListItemText, Grid, Card, CardHeader, CardContent } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';


const useStyle = makeStyles(theme => ({
    fullSizeTextField: {
        width: "100%"
    }
}))

const APPROVAL_OPTIONS = [
    {
        "value": "APPROVED",
        "label": "Approved"
    },
    {
        "value": "DECLINED",
        "label": "Declined"
    }
];

export default function ApprovalPanel(props) {

    const classes = useStyle();
    let [approvalOption, setApprovalOption] = React.useState(props.gmApproval);

    console.log("ApprovalPanel props:", approvalOption)

    const handleToggle = value => () => {
        setApprovalOption(value);
        if (props.handleApprovalSelect) {
            props.handleApprovalSelect(value);
        }
    }

    return (
        <Card className={classes.section}>
            <CardHeader title='Controller Approval' />
            <CardContent>
                <Grid container direction="column">
                    <Grid item>
                        <List>
                            {APPROVAL_OPTIONS.map(item => {
                                return (
                                    <ListItem key={item.value} onClick={handleToggle(item.value)}>
                                        <ListItemIcon>
                                            <Radio
                                                edge="start"
                                                checked={approvalOption === item.value}
                                                value={item.value}
                                            />
                                        </ListItemIcon>
                                        <ListItemText primary={item.label} />
                                    </ListItem>
                                )
                            })}
                        </List>
                    </Grid>
                    <Grid item>
                        <TextField
                            id="gmComment"
                            label="Controller Comment"
                            multiline
                            rows="5"
                            defaultValue=""
                            className={classes.fullSizeTextField}
                            margin="normal"
                            variant="outlined"
                            value={props.gmComment}
                            onChange={props.handlerGMCommentChange}
                        />
                    </Grid>
                </Grid>
            </CardContent>
        </Card>
    );
}