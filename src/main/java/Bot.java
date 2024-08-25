import commands.AppBotCommand;
import commands.BotCommonCommands;
import functions.FilterOperation;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import utils.PhotoMessageUtils;

import java.io.File;


//import static jdk.internal.joptsimple.internal.Messages.message;


public class Bot extends TelegramLongPollingBot {
    Class[] commandClasses = new Class[]{BotCommonCommands.class};

    @Override
    public String getBotUsername() {
        return "@EllHome_bot";
    }

    @Override
    public String getBotToken() {
        return "6881380748:AAG8ggXMkhXNxQmcl7bsCeW_lVnF1nvqjAE";
    }

    @Override
    public void onUpdateReceived(Update update) {



          Message message = update.getMessage();
          String response = message.getFrom().getId().toString();
          System.out.println(message.getText());
          SendPhoto sendPhoto = new SendPhoto();
          sendPhoto.setChatId(message.getChatId().toString());
          InputFile newFile = new InputFile();
          newFile.setMedia(new File("img.png"));
          sendPhoto.setPhoto(newFile);
          sendPhoto.setCaption("Элитное жильё ");

          SendMessage sendMessage = new SendMessage();
          sendMessage.setChatId(message.getChatId().toString());
          sendMessage.setText("Элитный квартал" + response);


          try {
              execute(sendMessage);
              execute(sendPhoto);

          } catch (TelegramApiException e) {
              e.printStackTrace();

      }
    }
}
// final String localFileName = "received_img.png";
//Message message = update.getMessage();
//try {
//    SendMessage responseTextMessage = runCommanCommand(message);
//    if (responseTextMessage != null) {
//        execute(responseTextMessage);
//        return;
//    }

//} catch (InvocationTargetException | IllegalAccessException | TelegramApiException | InstantiationException |
//         NoSuchMethodException e) {
//    e.printStackTrace();

//}

// String chatId = message.getChatId().toString();
// try

// {
//     ArrayList<String> photoPaths = new ArrayList<>(PhotoMessageUtils.savePhotos(getFilesByMessage(message),getBotToken()));
//     for(String path :photoPaths){
//         PhotoMessageUtils.processingImage(path);
//         String chatId = null;
//         execute(preparePhotoMessage(path,chatId));
//     }

// } catch (IOException e) {
//     e.printStackTrace();
// }  catch (Exception e) {
//     e.printStackTrace();
// }

// }


// private SendMessage runCommanCommand(Message message) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
//     String text = message.getText();

//     for (int i = 0; i < commandClasses.length; i++) {
//         BotCommonCommands commands = new BotCommonCommands();
//         Method[] classMethods = commands.getClass().getDeclaredMethods();
//         for (Method method : classMethods) {
//             if (method.isAnnotationPresent(AppBotCommand.class)) {
//                 AppBotCommand command = method.getAnnotation(AppBotCommand.class);
//                 if (command.name().equals(text)) {
//                     method.setAccessible(true);
//                     String responseText = (String) method.invoke(commands);
//                     if (responseText != null) {
//                         SendMessage sendMessage = new SendMessage();
//                         sendMessage.setChatId(message.getChatId().toString());
//                         sendMessage.setText(responseText);
//                         return sendMessage;
//                     }

//                 }
//             }
//         }
//         return null;
//     }

//     return null;
// }
// private Message runPhotoFilter(Message message){
//     List<File> files = getFilesByMessage(message);
//     return message;

// }
// private List<File> getFilesByMessage(Message message) {
//     List<PhotoSize> photoSizes = message.getPhoto();
//     ArrayList<File> files = new ArrayList<>();
//     for (PhotoSize photoSize : photoSizes) {


//         final String fileId = photoSize.getFileId();
//         try {

//             files.add(sendApiMethod(new GetFile(fileId)));

//         } catch (TelegramApiException e) {
//             e.printStackTrace();
//         }
//     }
//     return files;
// }

// private SendPhoto preparePhotoMessage(String localPath, String chatId) {
//     SendPhoto sendPhoto = new SendPhoto();
//     sendPhoto.setReplyMarkup(getKeyboard());
//     sendPhoto.setChatId(chatId);
//     InputFile newFile = new InputFile();
//     newFile.setMedia(new java.io.File(localPath));
//     sendPhoto.setPhoto(newFile);
//     //sendPhoto.setCaption("New Technologe");
//     return sendPhoto;
// }

// private ReplyKeyboardMarkup getKeyboard() {


//     ReplyKeyboardMarkup replayKeyboardMarkup = new ReplyKeyboardMarkup();
//     ArrayList<KeyboardRow> allKeyboardRows = new ArrayList<>();
//     allKeyboardRows.addAll(getKeyboardRows(BotCommonCommands.class));
//     allKeyboardRows.addAll(getKeyboardRows(FilterOperation.class));


//     replayKeyboardMarkup.setKeyboard(allKeyboardRows);
//     replayKeyboardMarkup.setOneTimeKeyboard(true);

//     return replayKeyboardMarkup;
// }


// private ArrayList<KeyboardRow> getKeyboardRows(Class someClass) {
//     Method[] classMethods = someClass.getDeclaredMethods();
//     ArrayList<AppBotCommand> commands = new ArrayList<>();
//     for (Method method : classMethods) {
//         if (method.isAnnotationPresent(AppBotCommand.class)) {
//             commands.add(method.getAnnotation(AppBotCommand.class));
//
//           }
//       }
//       ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
//
//       int columnCount = 3;
//       int rowsCount = (commands.size() / columnCount) + ((commands.size() % columnCount == 0) ? 0 : 1);
//       for (int rowIndex = 0; rowIndex < rowsCount; rowIndex++) {
//           KeyboardRow row = new KeyboardRow();
//           for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
//               int index = rowIndex * columnCount + columnIndex;
//               if (index >= commands.size()) continue;
//
//               AppBotCommand command = commands.get(rowIndex * columnCount + columnIndex);
//               KeyboardButton keyboardButton = new KeyboardButton(command.name());
//               row.add(keyboardButton);
//
//           }
//           keyboardRows.add(row);
//       }
//       return keyboardRows;
//   }
//}

