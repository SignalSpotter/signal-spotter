import { ModelInit, MutableModel, __modelMeta__, ManagedIdentifier } from "@aws-amplify/datastore";
// @ts-ignore
import { LazyLoading, LazyLoadingDisabled } from "@aws-amplify/datastore";





type EagerReports = {
  readonly [__modelMeta__]: {
    identifier: ManagedIdentifier<Reports, 'id'>;
    readOnlyFields: 'createdAt' | 'updatedAt';
  };
  readonly id: string;
  readonly user?: string | null;
  readonly x?: number | null;
  readonly y?: number | null;
  readonly datetime?: string | null;
  readonly createdAt?: string | null;
  readonly updatedAt?: string | null;
}

type LazyReports = {
  readonly [__modelMeta__]: {
    identifier: ManagedIdentifier<Reports, 'id'>;
    readOnlyFields: 'createdAt' | 'updatedAt';
  };
  readonly id: string;
  readonly user?: string | null;
  readonly x?: number | null;
  readonly y?: number | null;
  readonly datetime?: string | null;
  readonly createdAt?: string | null;
  readonly updatedAt?: string | null;
}

export declare type Reports = LazyLoading extends LazyLoadingDisabled ? EagerReports : LazyReports

export declare const Reports: (new (init: ModelInit<Reports>) => Reports) & {
  copyOf(source: Reports, mutator: (draft: MutableModel<Reports>) => MutableModel<Reports> | void): Reports;
}