import React from 'react';
import { Paper, Tabs, Tab, Card, CardHeader, CardContent, Grid } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import MutipleSelectionList from '../MutipleSelectionList';
import SingleSelectionList from '../SingleSelectionList';
import MasterDataService from '../../services/MasterDataService';

const useStyles = makeStyles(theme => ({
    section: {
        marginRight: theme.spacing(1),
        marginBottom: theme.spacing(1),
    },
    tabPanelSection: {
        marginTop: theme.spacing(1),
        marginLeft: theme.spacing(1),
    }
}));

function TabPanel(props) {
    const { children, value, index } = props;
    const classes = useStyles();
    return (
        <Grid className={classes.tabPanelSection} container style={{display: (value !== index)? "none": "" }}>
            <Grid item>
                {children}
            </Grid>
        </Grid>
    );
}

const lookupDataService = new MasterDataService();
let isLoaded = false;

export default function QualificationPanel(props) {
    const [value, setValue] = React.useState(2);
    const [educations, setEducations] = React.useState([]);
    const [skills, setSkills] = React.useState([]);
    const [experience, setExperience] = React.useState([]);
    const classes = useStyles();
    if(!isLoaded){
        lookupDataService.fetchEducations(setEducations);
        lookupDataService.fetchSkills(setSkills);
        lookupDataService.fetchExperience(setExperience);
        isLoaded = true;
    }

    

    console.log("QualificationPanel props:", props);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <Card className={classes.section}>
            <CardHeader title='Qualifications' />
            <CardContent>
                <Paper square>
                    <Tabs
                        value={value}
                        indicatorColor="primary"
                        textColor="primary"
                        onChange={handleChange}
                    >
                        <Tab label="Education" />
                        <Tab label="Skill" />
                        <Tab label="Experience" />
                    </Tabs>
                </Paper>

                <TabPanel value={value} index={0}>
                    <MutipleSelectionList disabled={props.disabled} list={educations} selectedValues={props.qualification.educations} handleItemSelect={props.handleEducationSelect}/>
                </TabPanel>
                <TabPanel value={value} index={1}>
                    <MutipleSelectionList disabled={props.disabled} list={skills} selectedValues={props.qualification.skills} handleItemSelect={props.handleSkillSelect}/>
                </TabPanel>
                <TabPanel value={value} index={2}>
                    <SingleSelectionList disabled={props.disabled} list={experience} selectedValues={props.qualification.experience} handleItemSelect={props.handleExperienceSelect}/>
                </TabPanel>
            </CardContent>
        </Card>

    );
}