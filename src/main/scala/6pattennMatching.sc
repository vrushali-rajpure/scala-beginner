import scala.util.Random

/*
Pattern matching is a mechanism for checking a value against a pattern.
 A successful match can also deconstruct a value into its constituent parts.
 It is a more powerful version of the switch statement in Java and
 it can likewise be used in place of a series of if/else statements.

A match expression has a value, the match keyword, and at least one case clause.
 */

val x: Int = Random.nextInt(10)

x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "no" // catch all
}

def matchExpression(cs : Int): String  = cs match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "no" // catch all
}

matchExpression(2)

//----------------------------------------

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

//def showNotification(notification: Notification) : String = {
//
//    notification match {
//        case SMS(_, message) => message
//        case Email(_, _,body) => body
//        case VoiceRecording(_,link) => link
//
//    }
//}
def showNotification(notification: Notification): String = {
    notification match {
        case Email(sender, title, _) =>
            s"You got an email from $sender with title: $title"
        case SMS(number, message) =>
            s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
            s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
}

val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

println(showNotification(someVoiceRecording))

//-----------------Pattern guards ---  boolean expressions which are used to make cases more specific

def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
        case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
            "You got an email from special someone!"
        case SMS(number, _) if importantPeopleInfo.contains(number) =>
            "You got an SMS from special someone!"
        case other =>
            showNotification(other) // nothing special, delegate to our original showNotification function
    }
}

val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

val someSms1 = SMS("867-5309", "Are you there?")
val someVoiceRecording1 = VoiceRecording("Tom", "voicerecording.org/id/123")
val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
val importantSms = SMS("867-5309", "I'm here! Where are you?")

println(showImportantNotification(someSms1, importantPeopleInfo))
println(showImportantNotification(someVoiceRecording1, importantPeopleInfo))
println(showImportantNotification(importantEmail, importantPeopleInfo))
println(showImportantNotification(importantSms, importantPeopleInfo))

// -- matching only type It is a convention to use the first letter of the type as the case identifier (
abstract class Device

case class Phone(model: String) extends Device {
    def screenOf = "Screen off"
}

case class Computer(model: String ) extends Device{
    def screenSaverOn = "Screen saver on"
}

def goIdle( device : Device) = device match {

    case p: Phone => p.screenOf
    case c: Computer => c.screenSaverOn
}

goIdle( Phone("s3"))
goIdle( Computer("xp"))