//calling the appropriate classes
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;

//this is the main class
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner kb=new Scanner(System.in);

        System.out.println("Print the file name:");//asking the user for file name
        String name=kb.next();

        File file=new File(name);//creating the file
        Scanner inputFile=new Scanner(new File(name));//scanning the file for data


        int vertex=Integer.valueOf(inputFile.nextLine().trim());//getting the number of vertex of graph from the file

        StringTokenizer token;
        String ver1,ver2;
        int x,y;

        int[][]	adjMatrix	=	new	int[vertex][vertex];//creating the array to hold the vertices

        ArrayList<String> vertices=new ArrayList<>();//this is the arraylist to store the vertices

        while(inputFile.hasNextLine()){//checking if the file has any more data

              token=new StringTokenizer(inputFile.nextLine()," ");

              //retriving the values from the token to our variables
              ver1=token.nextToken();
              ver2=token.nextToken();

              //adding the vertex elements to the arraylist for later use
              if((vertices.size()==0)||(!vertices.contains(ver1)))
              vertices.add(ver1);

              if(!vertices.contains(ver2))
                  vertices.add(ver2);

              x=ver1.charAt(0)-65;
              y=ver2.charAt(0)-65;

              adjMatrix[x][y]=1;//updating the matrix

              adjMatrix[y][x]=1;
        }

        System.out.println("\nThis is the matrix:\n");


        //displaying the matrix formed from the graph
     for (int i=0; i< vertex; i++){
       for (int j=0; j< vertex; j++){
         System.out.print(adjMatrix[i][j]+" ");

     }
     System.out.println();
     }

     Collections.sort(vertices);//sort the arraylist containing all the vertices
     System.out.println();
//     for(int i=0;i<vertices.size();i++){
//         System.out.print(vertices.get(i));
//     }

     boolean [] visited = new boolean[vertex];//create a boolean array




        System.out.println("\nThis is the graph traversal:");
        dfs(0, adjMatrix, visited, vertices );//this calls the recursive method and we are considering A as the starting point of traversal

        }



    public static void dfs(int a, int[][] matrix, boolean[] visited, ArrayList<String> vertices) {
        if(!visited[a]) {//check if the thing in the a position of the visited array is false
            visited[a] = true; //if not then set it to true

            System.out.print( vertices.get(a)+"  ");//prints the node name


            for (int b = 0; b < matrix[a].length; b++) {
                if (matrix[a][b] == 1 && !visited[b]) {//searches for the 1's in the column
                    dfs(b, matrix, visited, vertices); //goes to the node having 1
                }
            }
        }
    }

}
