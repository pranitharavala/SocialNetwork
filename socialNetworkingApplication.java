package socialNetwork;

public class socialNetworkingApplication {

	public static void main(String[] args) {
		Publish p = new Publish();
		p.publishMessages("Alice","I love the weather today.");
		p.viewTimeline("Alice");
		p.publishMessages("Bob","Darn! We lost!");
		p.publishMessages("Bob","Good game though.");
		p.viewTimeline("Bob");
		p.publishMessages("Charlie","I'm in New York today! Anyone wants to have a coffee?");
		p.publishMessages("Charlie","Coffee is good");
		p.followTimeline("Charlie","Alice");
		p.followTimeline("Charlie","Bob");
		p.viewTimeline("Charlie");
	}
}
