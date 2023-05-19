function manipulateStudentRecord(obj, operation, prop, newValue) {
  // write your code here
   
    var found = false;
    for(var val in obj) {
        if(val == prop) {
            found = true;
            break;
        }
    }
    
    if(operation == "edit" && found ) {
        if( newValue.length == 0) {  
            return obj;
        } else if(newValue.length > 0) {
            obj[prop] = newValue;
            return obj;
        }
    }   
    
    if(operation == "edit" && !found) {
        return obj;
    }
    
    if(operation == "delete") {
        
        obj[prop] = "";
        delete obj[prop];
        return obj;
    }
         
}