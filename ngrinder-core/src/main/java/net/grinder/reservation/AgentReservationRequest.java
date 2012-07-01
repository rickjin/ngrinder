package net.grinder.reservation;

import java.util.HashSet;
import java.util.Set;

import net.grinder.common.processidentity.AgentIdentity;
import net.grinder.util.Precondition;

/**
 * Agent assign request information.
 * 
 * @author JunHo Yoon
 */
public class AgentReservationRequest {
	private final String category;
	private final int requiredAgentCount;
	private final Set<AgentIdentity> assignedAgents = new HashSet<AgentIdentity>();

	public AgentReservationRequest(String category, int requiredAgentCount) {
		Precondition.notEmpty(category, "category should not be emtpy");
		Precondition.notZero(requiredAgentCount,
				"required count of agents should be not 0.");
		this.category = category;
		this.requiredAgentCount = requiredAgentCount;
	}

	public String getCategory() {
		return category;
	}

	public boolean isSameCategory(String category) {
		return category.equals(category);
	}

	public void addAssignedAgent(AgentIdentity agentIdentity) {
		getAssignedAgents().add(agentIdentity);
	}

	public Set<AgentIdentity> getAssignedAgents() {
		return assignedAgents;
	}

	public int getRequiredAgentCount() {
		return requiredAgentCount;
	}

	public int getAssigendAgentCount() {
		return assignedAgents.size();
	}

	public boolean isAllAgentAssigned() {
		return requiredAgentCount <= assignedAgents.size();
	}

}