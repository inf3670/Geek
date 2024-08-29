export const Sexe: { [key: string]: SexeOption } = {
    FEMININ: { name: 'FEMININ', value: 'Féminin' },
    MASCULIN: { name: 'MASCULIN', value: 'Masculin' }
};

export interface SexeOption {
    name: string;
    value: string;
}

