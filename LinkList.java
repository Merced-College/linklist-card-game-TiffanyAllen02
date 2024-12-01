
import java.util.ArrayList;
import java.util.Collections;
public class LinkList
{
	public void shuffleDeck() { // random order of cards //IMPLEMENTED BY TIFFANY
		ArrayList<Card> cardArray = new ArrayList<>();
		Link current = first;
		
		while (current!= null) {
			cardArray.add(current.cardLink);
			current = current.next;
		}
		Collections.shuffle(cardArray);

		first = null;

		for (Card card: cardArray) {
			add(card);
		}

	}
	private Link first;            // ref to first link on list

	//-------------------------------------------------------------
	public LinkList()              // constructor
	{
		first = null;               // no links on list yet
	}
	//-------------------------------------------------------------
	public void insertFirst(Card card)
	{                           // make new link
		Link newLink = new Link(card);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}
	public void add(Card card)
	{                           // make new link
		Link newLink = new Link(card);
		newLink.next = first;       // it points to old first link
		first = newLink;            // now first points to this
	}
	//-------------------------------------------------------------
	public Link find(Card cardToFind)      // find link with given key /// IMPLEMENTED BY TIFFANY: fixed unrelations between Card and Link
	{                           // (assumes non-empty list)
		Link current = first;              // start at 'first'
		while(current!= null)        // while no match,
		{
			if(current.cardLink.equals(cardToFind)) {
				// if end of list,
				return current;       
			    }          						// didn't find it
			else {                            // not end of list,
				current = current.next;      // go to next li
			}
		}
		return null;                    // found it
	}
	//-------------------------------------------------------------
	public Link delete(Card cardToFind)  {// delete link with given key //IMPLEMENTED BY TIFFANY: fixed unrelations between cardtoFind and Link
		if (first == null) {
			return null; //List is empty
		}
		Link current = first;
		Link previous = null;
		//find matching card
		while (current!= null &&!current.cardLink.equals(cardToFind)) {
			previous = current;
			current = current.next;
		}
		if (current == null) { // card not found
			return null;
		}
		if (previous == null) {
			first = first.next;
		}
		else {
			previous.next = current.next;
		}

		return current; //the deleted link
	} 

	//-------------------------------------------------------------
	public void displayList()      // display the list
	{
		System.out.print("List (first-->last): ");
		Link current = first;       // start at beginning of list
		while(current != null)      // until end of list,
		{
			current.displayLink();   // print data
			current = current.next;  // move to next link
		}
		System.out.println("");
	}
	//-------------------------------------------------------------

	//-------------------------------------------------------------
	public Card getFirst()    // delete link with given key
	{                           // (assumes non-empty list)
		Link current = first;              // search for link
		first = first.next;             //    change first
		return current.cardLink;
	}

}  // end class LinkList

