public class SimpleTeamLeader 
{
    public static void main(String[] args) 
    {
        InputFile inPut = new InputFile("in.txt");//construct input object
        OutputFile outPut = new OutputFile("out.txt");//construct output object

        int team = 0;//variable to save what team is read from the file
        String name = "";//variable to save what name is read from the file
        
        int count = 0;//initialize count variable for players on team
                
        while (!inPut.eof()) // use the eof method in the input class
        {  
            name=inPut.readWord();//read the name
            team=inPut.readInt();//read the team number
            count = count + 1;//add one for each team member

            if(count==3)//if this is the third team member make it the leader
            {
                outPut.writeWord(name);//write the name to file
                outPut.writeInt(team);//write the team to file
                outPut.writeEOL();//write the end of line marker
                System.out.println("The team leader is "+ name
                        +" for team " + team);
            } 
            if(count==5)//if this is the fifth team member 
            {
               count = 0;//reset the count variable for the new team
            }//end of the first team
            
        }//end of while eof() loop
        
        outPut.close(); //You must close the output file for the data to appear
    }//End of main method
    
}//End of class SimpleTeamLeader
