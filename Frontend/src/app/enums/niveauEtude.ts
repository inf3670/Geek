export const NiveauEtude: { [key: string]:  NiveauEtudeOption} = {
  BEPC: { name: 'Brevet d\'Études du Premier Cycle', value: 'BEPC' },
  Probatoire: { name: 'Probatoire', value: 'Probatoire' },
  BAC: { name: 'Baccalauréat', value: 'Baccalauréat' },
  HND: { name: 'Higher National Diploma', value: 'HND' },
  BTS: { name: 'Brevet de Technicien Supérieur', value: 'BTS' },
  DUT: { name: 'Diplôme Universitaire de Technologie', value: 'DUT' },
  DSEP: { name: 'Diplôme Supérieur d\'Études Professionnelles', value: 'DSEP' },
  Licence: { name: 'Licence', value: 'Licence' },
  Master: { name: 'Master', value: 'Master' },
  Doctorat: { name: 'Doctorat', value: 'Doctorat' }
};

export interface NiveauEtudeOption {
    name: string;
    value: string;
}
