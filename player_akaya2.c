//I foresee everything rock/paper scissors
rps whatToPlay(int round,rps *myhist,rps *opphist,int length){
	
	int counter=0;
	int k;
	int i;
	
	for (k=round-1-length;k>=length-1;k--){
	
		for (i=0;i<length;i++){
			if(myhist[round-1-i]==myhist[k-i])
				counter++;
		}
		if (counter==length){
			
			if (eval_round(myhist[k+1],opphist[k+1],NULL,NULL)==Player1){
					
				if (opphist[k+1]==Scissors)
					return Rock;		
				
				else if (opphist[k+1]==Paper)
					return Scissors;
				
				else 
					return Paper;
			
			}
			
			else if(eval_round(myhist[k+1],opphist[k+1],NULL,NULL)==Player2){
				
				if (opphist[k+1]==Scissors)
					return Scissors;		
				
				else if (opphist[k+1]==Paper)
					return Paper;
				
				else 
					return Rock;
					
			}
			
			else if(eval_round(myhist[k+1],opphist[k+1],NULL,NULL)==Tie){
				
				if (opphist[k+1]==Scissors)
					return Scissors;		
				
				else if (opphist[k+1]==Paper)
					return Paper;
				
				else 
					return Rock;
					
			}
	}
		else
			counter=0;
}

	return whatToPlay(round,myhist,opphist,length-1);
		
}

rps player_akaya2(int round,rps *myhist,rps *opphist) {
	
		if (round==0)
			return Paper;
		if (round==1)
			return Rock;
		if (round==2)
			return Scissors;
		
		int i=0;
		
		if((eval_round(myhist[round-1],opphist[round-1],NULL,NULL)==Tie)&&(eval_round(myhist[round-2],opphist[round-2],NULL,NULL)==Tie)&&(eval_round(myhist[round-3],opphist[round-3],NULL,NULL)==Tie))
		{
					
				if (opphist[round-1]==Scissors)
					return Rock;		
				
				else if (opphist[round-1]==Paper)
					return Scissors;
				
				else 
					return Paper;
			
			}
			
		return whatToPlay(round,myhist,opphist,round/2);

}

register_player(player_akaya2,"akaya2");






