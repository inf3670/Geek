export const NiveauLangue: Record<string, NiveauLangueOption> = {
  A1: { name: 'A1', value: 'Débutant' },
  A2: { name: 'A2', value: 'Élémentaire' },
  B1: { name: 'B1', value: 'Intermédiaire' },
  B2: { name: 'B2', value: 'Intermédiaire supérieur' },
  C1: { name: 'C1', value: 'Avancé' }
};

export interface NiveauLangueOption {
  name: string;
  value: string;
}
