from typing import List


class Solution:
    """
    Map<Skill name, Set<People>> - people by skills
    Each skill can be represented in a bit mask.
    So the first skill would be 0x0001, the second skill would be 0x0010, etc.
    So the Nth skill would set the Nth bit (from the right-most bit).

    Map<Skill bit mask, Set<People>> teammates by skill bit mask.
    For each person, find all their skills
    Create the skill bit mask for the current person
    Iterate over all previous stored entries in the teammates by skill bit mask Map
    For each entry, bitwise OR the existing entry's bit mask and the current person's skills bit mask
    If the combined bitmask does not exist in the Map OR the combined bitmask DOES exist in the Map, but the people associated
    with the existing bitmask is at least 1 person less than the people associated with the combined bitmask, update / set
    the value of the combined bitmask to copy the existing bitmask and add the current person.
    """

    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        index_by_skills = {v: i for i, v in enumerate(req_skills)}
        skill_bitmask_by_person = {}
        for person_index, skills in enumerate(people):
            skill_bitmask = 0
            for skill_index, skill in enumerate(skills):
                if skill in index_by_skills:
                    skill_bitmask |= 1 << index_by_skills.get(skill)
            skill_bitmask_by_person[person_index] = skill_bitmask

        dp = {0: set([])}
        for person_index, skill in enumerate(people):
            current_person_bitmask = skill_bitmask_by_person.get(person_index)
            for previous_team_bitmask, previous_teammates in dict(dp).items():
                combined_bitmask = previous_team_bitmask | current_person_bitmask
                if combined_bitmask != previous_team_bitmask:
                    if combined_bitmask not in dp or len(previous_teammates) + 1 < len(dp[combined_bitmask]):
                        combined_teammates = previous_teammates.copy()
                        combined_teammates.add(person_index)
                        dp[combined_bitmask] = combined_teammates

        # bit shifted 1 left N + 1 places (so 1, followed by N 0s)
        # subtract 1 to get a 1 in first N bits
        return list(dp[(1 << len(req_skills)) - 1])
