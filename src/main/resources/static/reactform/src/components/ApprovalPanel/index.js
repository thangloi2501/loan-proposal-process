import React from 'react';
import { Radio, List, TextField, ListItem, ListItemIcon, ListItemText, Grid, Card, CardHeader, CardContent } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';


const useStyle = makeStyles(theme => ({
    fullSizeTextField: {
        width: "100%"
    },
    section: {
        marginRight: theme.spacing(1),
        marginBottom: theme.spacing(1)
    },
    textField: {
		marginLeft: theme.spacing(1),
		marginRight: theme.spacing(1),
		width: 200,
	}
}))

const APPROVAL_OPTIONS = [
    {
        "value": "Y",
        "label": "YES"
    },
    {
        "value": "N",
        "label": "NO"
    }
];

export default function ApprovalPanel(props) {

    const classes = useStyle();
    let [approvalOption, setApprovalOption] = React.useState(props.approval);

    const handleToggle = value => () => {
        setApprovalOption(value);
        if (props.handleApprovalSelect) {
            props.handleApprovalSelect(value);
        }
    }

    return (
        <Card className={classes.section}>
            <CardHeader title='Decision' />
            <CardContent>
                <Grid container direction="column">
                    <Grid item className={classes.textField}>
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
                            id="comment"
                            label="Comment"
                            multiline
                            rows="5"
                            defaultValue=""
                            className={classes.fullSizeTextField}
                            margin="normal"
                            variant="outlined"
                            value={props.comment}
                            onChange={props.handleApprovalCommentChange}
                        />
                    </Grid>
                </Grid>
            </CardContent>
        </Card>
    );
}