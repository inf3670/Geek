export const NiveauLangue: Record<string, NiveauLangueOption> = {
  A1: { name: 'Débutant', value: 'A1' },
  A2: { name: 'Élémentaire', value: 'A2' },
  B1: { name: 'Intermédiaire', value: 'B1' },
  B2: { name: 'Intermédiaire supérieur', value: 'B2' },
  C1: { name: 'Avancé', value: 'C1' }
};

export interface NiveauLangueOption {
  name: string;
  value: string;
}
