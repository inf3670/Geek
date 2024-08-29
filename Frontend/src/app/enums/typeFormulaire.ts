export const TypeFormulaire: { [key: string]: TypeFormulaireOption } = {
    coursLangue: { name: 'coursLangue', value: "Cours d'allemand (en ligne/présentiel)" },
    coursInfo: { name: 'coursInfo', value: "Cours d'informatique" },
    coursInfoOnline: { name: 'coursInfoOnline', value: "Cours d'informatique (en ligne/présentiel)" },
    coursSecretariat: { name: 'coursSecretariat', value: "Cours de secrétariat" },
    FormulairePresence: { name: 'FormulairePresence', value: "Formulaire de Présence" },
    coursAnglais: { name: 'coursAnglais', value: "Cours d'anglais (en ligne/présentiel)" },
    assistanceVisaCanada: { name: 'assistanceVisaCanada', value: "Aide à l'obtention d'un visa pour le Canada" },
    assistanceVisaAllemagne: { name: 'assistanceVisaAllemagne', value: "Aide à l'obtention d'un visa pour l'Allemagne" }
};

export interface TypeFormulaireOption {
    name: string;
    value: string;
}
