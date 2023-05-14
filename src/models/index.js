// @ts-check
import { initSchema } from '@aws-amplify/datastore';
import { schema } from './schema';



const { Reports } = initSchema(schema);

export {
  Reports
};