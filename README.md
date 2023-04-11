# signal-spotter-cloud

This project contains source code and supporting files for a serverless application that is deployed and managed with AWS Amplify using GraphQL APIs.

## Build Instructions
1. Create *local.properties* file in the `app/src/main/resources/` directory.
2. Add the following lines: 
    - `API_ENDPOINT=<insert_endpoint_here>`
    - `API_KEY=<insert_api_key_here>`
3. Run `gradle build`
4. Run `gradle run`


**Tasks**
- [x] Design Graphql Schema
- [x] Create Java HTTP clients with Graphql queries and mutations
- [ ] Design and implement GUI using Java Swing
- [ ] Create UI and API unit tests


**Links/Sources**
- [AWS Amplify Docs](https://docs.amplify.aws) 
- [GraphQL Documentation](https://docs.aws.amazon.com/appsync/latest/devguide/graphql-overview.html) 
