export interface ICategory {
  id?: number;
  name?: string | null;
  description?: string | null;
  status?: string | null;
}

export const defaultValue: Readonly<ICategory> = {};
