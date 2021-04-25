import React from 'react';
import logo from './logo.svg';
import './App.css';
import ProposeDocument from './scenes/ProposeDocument';
import URLUtil from './services/URLUtil';
import Control1Approval from './scenes/Control1Approval';
import Control2Approval from './scenes/Control2Approval';

function App() {
  const utils = new URLUtil();
  const params = utils.getParameters(window.location.search);
  console.log("params: ", params);

  switch(params.taskName){
    case 'ProposeDocument':
        return (
          <ProposeDocument taskId={params.taskId} backUrl={params.callbackUrl}/>
        );
    case 'Control1Approval':
        return (
          <Control1Approval taskId={params.taskId} backUrl={params.callbackUrl}/>
        );
    case 'Control2Approval':
        return (
          <Control2Approval taskId={params.taskId} backUrl={params.callbackUrl}/>
        )
    default:
      return(
        <div></div>
      );
  }
}

export default App;
