package org.clothocad.client.layers.communication;

public enum Channel {

//HUMAN INTERACTION
    autocomplete, //Return potential commands that start with this substring
    autocompleteDetail, //Return the metadata for a Sharable
    submit, //Run this sloppy or concrete command
    clear, //Replace the scriptengine behind mind with a fresh version
    login, //Log me into Clotho on this client with this login/password
    logout, //Log me out of Clotho
    changePassword, //Change my password to this new value
    learn, //associate this String with this execution statement
    

//LOGGING AND MESSAGING
    log, //write a message to the console.log spot
    say, //Post a message to all search bars for this Person
    note, //Remember this message in my personal log (not implemented)
    alert, //Post an alert to this Person, wherever they say they want to be contacted in preferences.  This isn't a javascript alert().  That is just one implementation.

    
//DATA MANIPULATION
    get, //Get the Sharable with this uuid
    set, //Change the state of the Sharable with this uuid with this new JSON data
    create, //Create a new sharable with this Schema
    destroy, //Delete a sharable with this uuid
    query, //Find all Sharables that satisfy this formally-expressed constraint
    
//EXECUTION
    run, //run this Function
    show, //Instantiate the View with this uuid
    startTrail, //Show this trail
    edit, //Open a sharable in an editor
    listen, //Listen for events, and in response do this execution statement
    unlisten, //Remove a listener for an event
    
// RESPONSE
    response // the clotho3 core responds a message to the requesting client
}