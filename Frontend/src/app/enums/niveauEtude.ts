export const NiveauEtude: { [key: string]:  NiveauEtudeOption} = {
  BEPC: { name: 'BEPC', value: 'Brevet d\'Études du Premier Cycle' },
  Probatoire: { name: 'Probatoire', value: 'Probatoire' },
  BAC: { name: 'Baccalauréat', value: 'Baccalauréat' },
  HND: { name: 'HND', value: 'Higher National Diploma' },
  BTS: { name: 'BTS', value: 'Brevet de Technicien Supérieur' },
  DUT: { name: 'DUT', value: 'Diplôme Universitaire de Technologie' },
  DSEP: { name: 'DSEP', value: 'Diplôme Supérieur d\'Études Professionnelles' },
  Licence: { name: 'Licence', value: 'Licence' },
  Master: { name: 'Master', value: 'Master' },
  Doctorat: { name: 'Doctorat', value: 'Doctorat' }
};

export interface NiveauEtudeOption {
    name: string;
    value: string;
}
