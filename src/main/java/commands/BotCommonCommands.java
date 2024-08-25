package commands;

import org.telegram.telegrambots.meta.api.objects.File;

public class BotCommonCommands {


    @AppBotCommand(name = "/hello", description = "when request hello", showInHelp = true)
    String hello() {
        return "hello, User";

    }



    @AppBotCommand(name = "/bye", description = "when request bye", showInHelp = true)
    String bye() {
        return "bye, User";
    }


    @AppBotCommand(name = "/help", description = "when request help", showInKeyboard = true)
    String help() {
        return "Images";

    }
    @AppBotCommand(name = "/start", description = "when request help", showInKeyboard = true)
    String start()  {

        return "\"Элитный квартал\"+response";


    }

}
