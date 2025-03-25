package src;

public class PrepareListsTest {
    public static void main(String[] args) {
        // Create an instance of PrepareLists
        PrepareLists prepareLists = new PrepareLists();

        // Run the AddData method to populate the data structures
        prepareLists.AddData();

        // Verify if the data structures are populated correctly
        // Example: Check a specific DList
        String dlistName = "dlist_30";
        DList dlist30 = prepareLists.getDList(dlistName);
        if (dlist30 != null) {
            System.out.println("DList " + dlistName + " exists and is populated.");
        } else {
            System.err.println("DList " + dlistName + " does not exist.");
        }

        // Example: Check a specific AList
        String alistName = "alist_30";
        AList alist30 = prepareLists.getAList(alistName);
        if (alist30 != null) {
            System.out.println("AList " + alistName + " exists and is populated.");
        } else {
            System.err.println("AList " + alistName + " does not exist.");
        }

        // Example: Check a specific AListPool
        String alistPoolName = "alistPool_30";
        AListPool alistPool30 = prepareLists.getAListPool(alistPoolName);
        if (alistPool30 != null) {
            System.out.println("AListPool " + alistPoolName + " exists and is populated.");
        } else {
            System.err.println("AListPool " + alistPoolName + " does not exist.");
        }

        // Example: Check a specific LinkedListPool for AList
        String linkedListPoolForAListName = "linkedListPoolForAList_30";
        LinkedListPool linkedListPoolForAList30 = prepareLists.getLinkedListPoolForAList(linkedListPoolForAListName);
        if (linkedListPoolForAList30 != null) {
            System.out.println("LinkedListPool for AList " + linkedListPoolForAListName + " exists.");
        } else {
            System.err.println("LinkedListPool for AList " + linkedListPoolForAListName + " does not exist.");
        }

        // Example: Check a specific LinkedListPool for DList
        String linkedListPoolForDListName = "linkedListPoolForDList_30";
        LinkedListPool linkedListPoolForDList30 = prepareLists.getLinkedListPoolForDList(linkedListPoolForDListName);
        if (linkedListPoolForDList30 != null) {
            System.out.println("LinkedListPool for DList " + linkedListPoolForDListName + " exists.");
        } else {
            System.err.println("LinkedListPool for DList " + linkedListPoolForDListName + " does not exist.");
        }
    }
}