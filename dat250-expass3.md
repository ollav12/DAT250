# DAT250 - Expass 3
- Olav Høysæther Opheim

## Short report
In this expass i have created a simple GUI interface for users to create a user, create a poll and vote polls. The components
are very basic but gets the job done. You first have to create a user by inputting a username and email, then you are "logged in/allowed to create and vote on polls".
you can now create polls and vote on polls that are created. This works well and you can also run bruno tests to see that a user is created, and so is the polls and votes are registerd aswell.

Steps:
- Step 1 - I setup a node project using svelte
- Step 2 - I developed CreateUserComponent, CreatePollComponent and VoteComponent.
- Step 3 - I enabled CORS-headers for the controller for testing purposes.
- Step 4 - I Integrated the frontend and backend with fetch.
- Step 5 - I deployed the frontend into the backend by building the frontend files and copying them into the static files in the backend project.
- Step 6 - I did not look at the extensions.

## Technical problems
- I had no issues in this expass when it came to setting up the node project or integrating the frontend with the backend. It's was
my first time using svelte so it was a bit difficult to get started, but the documentation was good so that helped a lot.

## Link to code
- Link to frontend GitHub repository if that is needed: https://github.com/ollav12/DAT250Expass3
- There were only minor changes to the backend like just adding the @CrossOrigin(...) to the controller files

## Pending issues
- I was able to complete all the steps (besides the optional step 6). I think the application
works fine, but there are improvements to be made like: a user can vote mutliple times on a poll with the same option, and more of these type of "issues/problems". I think these will
be resolved once we integrate this with a database for storing user data and we can then validate if a user should be able to vote for a given poll etc.
