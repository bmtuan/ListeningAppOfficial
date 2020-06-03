// package src.Controller;

// import src.Model.User;
// import src.View.LoginPanel;
// import src.View.MainFrame;
// import src.View.MenuPanel;
// import src.View.View;

// public class SessionController {
//     private View sessionView;
//     private User user;
//     public SessionController(){}
//     public void initSession(User user){
//         MenuPanel menuPanel = new MenuPanel();
//         this.user = user;
//         menuPanel.showUserInfo(user);
//         sessionView = menuPanel;
//         MenuController menuController = new MenuController(menuPanel, this);
//         MainFrame.refresh(sessionView);
//     }
//     public void updateSessionView(View newView){
//         sessionView = newView;
//         MainFrame.refresh(sessionView);
//     }
//     public void endSession(){
//         LoginPanel loginPanel = new LoginPanel();
//         LoginController loginController = new LoginController(loginPanel);
//         MainFrame.refresh(loginPanel);
//     }
//     public View getSessionView() {
//         return sessionView;
//     }

//     public void setSessionView(View sessionView) {
//         this.sessionView = sessionView;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }
    
// }