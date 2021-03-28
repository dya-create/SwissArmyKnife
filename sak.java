/* Diya Patel
Object Oriented Programming
Sprint 5 : Command Line Application 
*/

public class sak {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("*******Welcome to SwissArmyKNife*****");

        // when -help is entered... showing instructions on how to use the application
        if ((args.length < 1) || (args[0].equalsIgnoreCase("-Help"))) {

            if (args.length < 1) {
                System.out.println("Please enter one argument to utilize this application. Please use the \"-Help\"argument for" + "more information. Help section is printed below");
            }
            Help.printHelp();
            System.exit(0);

        }

        // Responding to the “-HttpRequest [URL]” and "-HttpRequestIndex [URL]" command-line parameter assuming case insensitivity
        else if (((args[0].equalsIgnoreCase("-HttpRequest")) || (args[0].equalsIgnoreCase("-HttpRequestIndex"))) && (args.length != 2)) {

            System.out.println("The argumennt provided is not a valid input. Please use the -Help argument for a guide");
            System.exit(0);

        }
        String url = args[1];

        // responsing the httprequest and printing the data to the command line
        if (args[0].equalsIgnoreCase("-HttpRequest")) {

            HttpRequest request = new HttpRequest();
            System.out.println("-executing request");

            if (request.readURL(url)) {
                System.out.println(request);
            } else {
                System.out.format("Unable to access", url);
            }
        }

        // responding to -httprequestindex and printing the data 
        if (args[0].equalsIgnoreCase("-HttpRequestIndex")) {

            HttpRequestIndex requestIndex = new HttpRequestIndex();
             System.out.println("-executing HttpRequestIndex");

            if (requestIndex.readURL(url)) {
                System.out.println(requestIndex);
                }
            } else {
                System.out.format("Unable to access requested URL: ", url); 
            }
        }  

    }
