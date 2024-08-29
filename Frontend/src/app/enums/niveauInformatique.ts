export const NiveauInformatique: { [key: string]: NiveauInformatiqueOption } = {
    Debutant: { name: 'Debutant', value: "Je n'ai pas ou peu de connaissances en informatique" },
    Intermediaire: { name: 'Intermediaire', value: 'Je sais utiliser les logiciels de base comme Word, Excel, etc.' },
    Avance: { name: 'Avance', value: 'Je sais coder, utiliser des logiciels complexes, etc' }
  };
  
export interface NiveauInformatiqueOption {
    name: string;
    value: string;
}
