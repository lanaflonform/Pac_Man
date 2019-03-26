/**
 * fichier.txt:
 * **********************************************************
 * nombre d'alphabets,nombre d'etats,nombre d'etats finaux  *
 * alphabet1,alphabet2....,alphabetn                   		*
 * etat1,etat2.............,etatn                      		*
 * etatfinal1,.....etatfinaln                          		*
 * etat_initial                                        		*
 * etat1,alphabet,etat_suivant                         		*
 * eta2,alphabet,etat_suivant                          		*
 *  .....                                                 	*
 * etatn,alphabet,etat_suivant                          	*
 * **********************************************************
 */
import java.io.*;
import java.util.*;


public class Automate{
	
    String 	nomfich;		//nom du fichier
    String 	alphabet[];		//alphabet
    String 	etat[];			//etats
    String 	qi;				//etat initial
    String 	f[];			//etats finaux
    

   @SuppressWarnings("resource")
   public Automate(String nomf)throws IOException
    {
        int nx,ne,nf;
        String lin;
        nomfich=nomf;
		BufferedReader fin =new BufferedReader(new FileReader(nomfich));
        lin=fin.readLine();
        StringTokenizer st=new StringTokenizer(lin," ?,.;:");
        nx=Integer.parseInt(st.nextToken());
        alphabet=new String[nx];
        ne=Integer.parseInt(st.nextToken());
        etat=new String[ne];
        nf=Integer.parseInt(st.nextToken());
        f=new String[nf];
        lin=fin.readLine();
        st=new StringTokenizer(lin," ?,.;:");
       int i=0;
        while(st.hasMoreTokens()){
            alphabet[i]=st.nextToken();
            i++;
        }
        lin=fin.readLine();
        st=new StringTokenizer(lin," ?,.;:");
        i=0;
        while(st.hasMoreTokens()){
            etat[i]=st.nextToken();
            i++;
        }

        lin=fin.readLine();
        st=new StringTokenizer(lin," ?,.;:");
        i=0;
        while(st.hasMoreTokens())
        {
            f[i]=st.nextToken();
            i++;
        }
        lin=fin.readLine();
        st=new StringTokenizer(lin," ?,.;:");
        qi=st.nextToken();
    }

   ///fonction delta
   @SuppressWarnings("resource")
   public String Delta(String e,String x)throws IOException{
        String lin,el,sl,es;
        boolean trouve=false;
        es="";
        el="";
        sl="";
		BufferedReader fin =new BufferedReader(new FileReader(nomfich));
        StringTokenizer st;
        while(((lin=fin.readLine())!=null)&&(!(trouve)))
        {
            st = new StringTokenizer(lin," ?,.;:");
           if(st.hasMoreTokens())
             el=st.nextToken();
            if(el.equals(e))
            {
                if(st.hasMoreTokens())
                sl=st.nextToken();
                if(sl.equals(x))
                {
                    if(st.hasMoreTokens())
                    es = st.nextToken();
                    trouve=true;
                }
            }
        }
        return es;
    }

   //Fonction de vérification
   public boolean verif(String ei,String w){

        boolean v=false,x=true;
        String res="";
        
        try{
	        if(w.length()==1){
	            res = Delta(ei, w);
	            x=false;
	        }else
	            v=verif(Delta(ei,w.substring(0,1)),w.substring(1));
        }catch(IOException e){
             System.out.println(e);
        }
        
        int i=0;
        while((i<f.length)&&(!v)&&(!x)){
            if(res.equals(f[i]))
                v=true;
            i++;
        }
        x=true;
        return v;
    }
}