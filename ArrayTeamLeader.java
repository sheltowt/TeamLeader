package SimpleTeamLeader;

public class ArrayTeamLeader 
{
    public static void main(String[] args) 
    {
        InputFile inPut = new InputFile("names.txt"); //construct input object
        OutputFile outPut = new OutputFile("TeamLeaderReport.txt");//construct output object
        
        String[] teamLeader = new String[100];//initialize new teamLeader array
        int[] memberCount = new int[100];//initialize new count array for amount on team

        String name="";//variable to hold name from the file being read
        int team=0;//variable to hold the team number from the file
        boolean firstTime = true;//variable used to control the blank lines in output file
                
        int index=0;//initialize index for loop
        for(index=0;index<100;index++)//Loop through to initialize the variables
        {
            teamLeader[index]="";//initialize each teamLeader value to a blank string
            memberCount[index]=0;//initialize each count value to 0
        }
        
        while (!inPut.eof()) //use the eof method to check for end of file
        {
            name = inPut.readWord();//initialize local variables to store data read
            team = inPut.readInt();//initialize local variables to store data read
            
            memberCount[team]=memberCount[team]+1;//add one to the team number read in
            
            if(memberCount[team]<4)//store the name as teamLeader if it is 3 or less
            {
                teamLeader[team]=name;//store the name to teamLeader
            }
        }
        
        index=1;//reset x value to one so we can write the data with a loop
        while(index<100)//go through each value in the array
        {
            if(memberCount[index]>=1)//only write files that have information
            {
                if(firstTime)//if this is the first time through 
                {
                    firstTime=false;//change the variable to false 
                }
                else
                {
                    //put end of line marker if it is not the first time through
                    outPut.writeEOL();
                }

                outPut.writeInt(index);//write the team number
                outPut.writeWord(teamLeader[index]);//write the teamLeaders name to file
                outPut.writeInt(memberCount[index]);//write how many people on each team
                
                //output to the screen for the user team number, name, and how many on team
                System.out.println(index + " "+teamLeader[index]+" "
                        +memberCount[index]);
                
            }
            index=index+1;//increment x so we can get out of the loop
        }
        outPut.close();//close the file so the records show up
    }//End of main method
}//End of class ArrayTeamLeader
