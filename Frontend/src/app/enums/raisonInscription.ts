export const RaisonInscription: { [key: string]: RaisonInscriptionOption } = {
  ETUDIER: { name: 'ETUDIER', value: 'Pour aller étudier en Allemagne' },
  TRAVAILLER: { name: 'TRAVAILLER', value: 'Pour aller travailler en Allemagne' },
  REGROUPEMENT: { name: 'REGROUPEMENT', value: 'Pour un regroupement familial' },
  AFFAIRES: { name: 'AFFAIRES', value: 'Pour les affaires' },
  CONNAISSANCES: { name: 'CONNAISSANCES', value: 'Pour renforcer mes connaissances' },
  AUTRES: { name: 'AUTRES', value: 'Autres' }
};

export interface RaisonInscriptionOption {
  name: string;
  value: string;
} 