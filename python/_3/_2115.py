"""
https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
"""

from typing import List


class Solution:
    """
    DFS Approach:

    Pick a recipe.
    Look at the ingredients for the recipe.
    Identify which ingredients are not in the supplies - these are the ingredients that are recipes.
    If there are ingredients that are not in recipes, then the underlying recipe is not possible.
    For each of these recipes (that are also ingredients), check if recipe is possible (keep track of which recipes have been visited and possible in a Map).
    If recipe is possible, return true.
    """

    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        s = set(supplies)
        possible_by_recipe_name = {}
        ingredients_by_recipe = dict(map(lambda index: [recipes[index], ingredients[index]], range(len(recipes))))

        for recipe_index, recipe_name in enumerate(recipes):
            if recipe_name not in possible_by_recipe_name:
                possible_by_recipe_name[recipe_name] = self.dfs(recipe_name,
                                                                ingredients_by_recipe,
                                                                possible_by_recipe_name,
                                                                s)

        return [key for (key, value) in possible_by_recipe_name.items() if value is True]

    def dfs(self, recipe_name, ingredients_by_recipe, possible_by_recipe_name, supplies):
        if recipe_name not in possible_by_recipe_name:
            possible_to_create_recipe = True
            recipe_ingredients = ingredients_by_recipe.get(recipe_name)
            for recipe_ingredient in recipe_ingredients:
                if recipe_ingredient not in supplies:
                    if recipe_ingredient not in ingredients_by_recipe \
                            or not self.dfs(recipe_ingredient,
                                            ingredients_by_recipe,
                                            possible_by_recipe_name,
                                            supplies):
                        possible_to_create_recipe = False
                        break
            possible_by_recipe_name[recipe_name] = possible_to_create_recipe
        return possible_by_recipe_name[recipe_name]
