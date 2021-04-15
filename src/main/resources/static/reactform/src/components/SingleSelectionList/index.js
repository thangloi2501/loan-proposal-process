import React from 'react';
import { Radio, ListItem, ListItemIcon, ListItemText, makeStyles, List } from '@material-ui/core';

const useStyles = makeStyles(theme => ({
    root: {
        width: '100%',
        maxWidth: 360,
        backgroundColor: theme.palette.background.paper,
    },
}));

export default function SingleSelectionList(props){
    
    const classes = useStyles();
    // const [checked, setChecked] = React.useState(props.selectedValues);
    const checked = props.selectedValues;
    // const [list, setList] = React.useState(props.list)
    const list = props.list;

    const handleToggle = value => () => {
        // setChecked(value);
        if(props.handleItemSelect){
            props.handleItemSelect(value, props.otherInputs);
        }
    }

    return(
        <List className={classes.root}>
            {list.map(item => {
                const labelId = `checkbox-list-label-${item.value}`;

                return (
                    <ListItem disabled={props.disabled} key={item.value} dense button onClick={handleToggle(item.value)}>
                        <ListItemIcon>
                            <Radio
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