import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Checkbox from '@material-ui/core/Checkbox';
import ListItemIcon from '@material-ui/core/ListItemIcon';

/**
 * A multiple selection list
 */

const useStyles = makeStyles(theme => ({
    root: {
        width: '100%',
        maxWidth: 360,
        backgroundColor: theme.palette.background.paper,
    },
}));

export default function MutipleSelectionList(props) {
    const classes = useStyles();
    // const [checked, setChecked] = React.useState(props.selectedValues);
    const checked = props.selectedValues;
    // const [list, setList] = React.useState(props.list)
    const list = props.list;

    console.log("MutipleSelectionList props:", props, checked);

    const handleToggle = value => () => {

        const currentIndex = checked.indexOf(value);
        const newChecked = [...checked];

        if (currentIndex === -1) {
            newChecked.push(value);
        } else {
            newChecked.splice(currentIndex, 1);
        }

        // setChecked(newChecked);
        if(props.handleItemSelect){
            props.handleItemSelect(newChecked, props.otherInputs)
        }
    };

    return (
        <List className={classes.root}>
            {list.map(item => {
                const labelId = `checkbox-list-label-${item.value}`;

                return (
                    <ListItem disabled={props.disabled} key={item.value} role={undefined} dense button onClick={handleToggle(item.value)}>
                        <ListItemIcon>
                            <Checkbox
                                edge="start"
                                checked={checked.indexOf(item.value) !== -1}
                                tabIndex={-1}
                                disableRipple
                                inputProps={{ 'aria-labelledby': labelId }}
                            />
                        </ListItemIcon>
                        <ListItemText id={labelId} primary={item.label} />
                    </ListItem>
                );
            })}
        </List>
    );
}