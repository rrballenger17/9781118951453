

import java.io.*;


class InputOutput{  
    public static void main(String args[]){  

    	// file output stream creates file
    	// output stream writer - myFile and "UTF8"
    	// buffered writer - the previous
		try (
			FileOutputStream myFile = new FileOutputStream("abc.txt");
            Writer out = new BufferedWriter(new OutputStreamWriter(myFile, "UTF8"));
			) 
		{
			String myAddress = "123 Broadway, New York, NY 10011";
			out.write(myAddress);

		} catch(IOException e){
			e.printStackTrace();

		}

		// file input stream opens file
		// input stream reader - previous and "UTF8"
		// buffered reader - the previous
		// reader.read() for one character
		StringBuffer buffer = new StringBuffer();
		try (
			FileInputStream myFile = new FileInputStream("abc.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(myFile, "UTF8");
			Reader reader = new BufferedReader(inputStreamReader);
		){

			int ch; // the code of one character
			while ((ch = reader.read()) > -1) {
				buffer.append((char)ch);
			}

            System.out.println(buffer.toString());
        
        } catch (IOException e) {
            e.printStackTrace();
		}

    }  
}  