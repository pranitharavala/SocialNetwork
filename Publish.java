package socialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publish {
	Map<String, Map<String, List<String>>> publishing;
	Publish() {
		publishing = new HashMap<String, Map<String, List<String>>>();
	}
	void publishMessages(String name, String message) {
		HashMap<String, List<String>> existingmessagesmap = new HashMap<String, List<String>>();
		List<String> existingmessages = new ArrayList<>();
		if (publishing.containsKey(name)) {
			existingmessagesmap = (HashMap<String, List<String>>) publishing.get(name);
			existingmessages = existingmessagesmap.get(name);
		}
		existingmessages.add(message);
		existingmessagesmap.put(name, existingmessages);
		publishing.put(name, existingmessagesmap);
	}

	void viewTimeline(String name) {
		if (publishing.containsKey(name)) {
			HashMap<String, List<String>> existingmessagesmap = new HashMap<String, List<String>>();
			existingmessagesmap = (HashMap<String, List<String>>) publishing.get(name);
			if (existingmessagesmap.size() > 1) {
				ArrayList<String> maintimeline = (ArrayList<String>) existingmessagesmap.get(name);
				System.out.println("**********"+name +"'s timeline"+"**********");
				for (int i = maintimeline.size() - 1; i >= 0; i--)
					System.out.println(name + " - " + maintimeline.get(i));
				for (Map.Entry mapElement : existingmessagesmap.entrySet()) {
					if (mapElement.getKey() == name)
						break;
					List<String> existingmessages = (List<String>) mapElement.getValue();
					for (int i = existingmessages.size() - 1; i >= 0; i--)
						System.out.println(mapElement.getKey() + " - " + existingmessages.get(i));
				}
			} else {
				for (Map.Entry mapElement : existingmessagesmap.entrySet()) {
					List<String> existingmessages = (List<String>) mapElement.getValue();
					System.out.println("**********"+name +"'s timeline"+"**********");
					for (int i = existingmessages.size() - 1; i >= 0; i--)
						System.out.println(existingmessages.get(i));
				}
			}
		}
	}

	void followTimeline(String name1, String name2) {
		if (publishing.containsKey(name1)) {
			HashMap<String, List<String>> addmessagesmap = new HashMap<String, List<String>>();
			addmessagesmap = (HashMap<String, List<String>>) publishing.get(name2);
			HashMap<String, List<String>> existingmessagesmap = new HashMap<String, List<String>>();
			existingmessagesmap = (HashMap<String, List<String>>) publishing.get(name1);
			existingmessagesmap.putAll(addmessagesmap);
			publishing.put(name1, existingmessagesmap);
		}
	}
}
