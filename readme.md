# Subject: RBAC
Role-based access control is a security mechanism aiming at protecting confidentiality and integrity of resources. Within RBAC, users are affected to roles. Then, roles receive authorizations which are an association between an action and a resource (for instance, an authorization ‘WriteFilesAuth’ could link the action ‘write’ to the resource ‘myFile.txt’.

A monitor is responsible for applying security checks by providing a method ‘canAccess’, returning true when a given user can access a given resource to perform a specific action and false otherwise (a user can access a resource if he belongs to a role with this kind of authorization).

A user is defined by its FirstName and LastName. They are associated to a monitor that they use to check if they can access a given resource. This check will return the string ‘access granted’ when the user has the right to perform the given action towards the resource, and ‘access denied’ otherwise. Users could be given the ‘blocked’ state if they do not behave properly, trying to access resources they don’t have the right to access to.

Roles are defined by their name, a list of users belonging to the role, a list of authorizations and an update mechanism.

The update mechanism removes all the users from a role if they are blocked.

The monitor knows all the existing roles.

## Scenario
Your design and realization should reflect the following scenario:
1. There is a user with the name ‘James Gosling’
1. There is an action ‘read’ and an action ‘write’
1. There is a resource called ‘myFile.txt’
1. There is an authorization ‘ReadPersoFile’ linking the action ‘read’ and the resource ‘myFile.txt’
1. There is a role named ‘baserole’. This role has the authorization ‘ReadPersoFile”. James Gosling is in the list of users for this baserole.
1. There is a monitor knowing the ‘baserole’ role

## Implementation
1. Before implementing, think about the **design** of your Classes, members, methods…
1. Create the **Java classes** implementing the described system. Write the necessary elements in the convenient classes to be able to create a user, a role, an authorization, a resource and link all of this according to the subject.
1. Create a method public *Boolean isUserInRole(User u)* in the convenient class.
1. Add a statement performing a call where a user would get the *“access granted”* printed on the console. Same for *“access denied”*

