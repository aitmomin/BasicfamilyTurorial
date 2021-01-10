package org.eclipse.sirius.sample.basicfamily.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.sample.basicfamily.Person;

/**
 * The services class used by VSM.
 */
public class Services {
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }
    
    public int getCousinsNumber(Person p) {
		
    	List<Person> cousins = new ArrayList<Person>();
    	List<Person> parents = p.getParents();
    	for (Person parent : parents) {
			for (Person grandParent : parent.getParents()) {
				for (Person uncleOrAunt : grandParent.getChildren()) {
					if (!parents.contains(uncleOrAunt)) {
						for (Person cousin : uncleOrAunt.getChildren()) {
							if (!cousins.contains(cousin)) {
								cousins.add(cousin);
							}
						}
					}
				}
			}
		}    	     	
    	return cousins.size();
	}
}
