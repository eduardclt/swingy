package za.co.wethinkcode.swingy;

import za.co.wethinkcode.swingy.controller.MainGameController;
import za.co.wethinkcode.swingy.controller.ValidatorFactoryController;

public class Main {
    public static void main(String[] args) {
        ValidatorFactoryController errors = new ValidatorFactoryController();
        try {
            if (args.length == 1){
                switch(args[0].toLowerCase()){
                    case "console":
                        MainGameController.readToList();
                        MainGameController.CLIrun();
                        break;
                    case "gui":
                        MainGameController.readToList();
                        MainGameController.GUIrun();
                        break;
                        default:
                            System.out.println(Colors.RED + "Invalid parameters. \nUsage: java -jar file.jar [gui/console]");
                            break;
                }
            }else {
                System.out.println(Colors.RED + "Invalid parameters. \nUsage: java -jar file.jar [gui/console]");
            }
        }catch(NumberFormatException e){
            System.out.println(Colors.RED + e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Colors.RED + "Make sure the text file contains at least 7 parameters per player, separated by a comma.");
        }catch (RuntimeException e){
            System.out.println(Colors.RED + e.getMessage());
        }catch(Exception e){
            System.out.println(e.toString());
            System.out.println("There was an error in the program");
        }
    }
}
