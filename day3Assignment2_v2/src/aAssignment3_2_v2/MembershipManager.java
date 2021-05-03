package aAssignment3_2_v2;

public class MembershipManager {
	
	//Veya enroll
	public void add(Membership membership) {
		Membership[] memberships = Database.getInstance().memberships;
		Membership[] tempMemberships = memberships;
		memberships = new Membership[memberships.length+1];
		
		for (int i = 0; i < tempMemberships.length; i++) {
			memberships[i] = tempMemberships[i];
		}
		
		
		Database.getInstance().membershipId += 1;
		int newId = Database.getInstance().membershipId;
		membership.id = newId;
		
		memberships[memberships.length-1] = membership;
		
		Database.getInstance().memberships = memberships;
	}
}
