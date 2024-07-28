public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello, this is an email notification.");

        Notifier smsDecorator = new SMSNotifierDecorator(emailNotifier);
        smsDecorator.send("Hello, this is an SMS notification.");

        Notifier slackDecorator = new SlackNotifierDecorator(smsDecorator);
        slackDecorator.send("Hello, this is a Slack notification.");
    }
}