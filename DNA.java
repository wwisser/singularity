import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class to represent a Gene
class GeneDna {
    private String name;
    private double riskFactor; // Represents the likelihood this gene contributes to schizophrenia

    public Gene(String name, double riskFactor) {
        this.name = name;
        this.riskFactor = riskFactor;
    }

    public String getName() {
        return name;
    }

    public double getRiskFactor() {
        return riskFactor;
    }

    @Override
    public String toString() {
        return "Gene{name='" + name + "', riskFactor=" + riskFactor + "}";
    }
}

// Class to represent Environmental Factor
class EnvironmentalFactor {
    private String name;
    private double riskMultiplier; // Amplifies or reduces genetic risks

    public EnvironmentalFactor(String name, double riskMultiplier) {
        this.name = name;
        this.riskMultiplier = riskMultiplier;
    }

    public String getName() {
        return name;
    }

    public double getRiskMultiplier() {
        return riskMultiplier;
    }

    @Override
    public String toString() {
        return "EnvironmentalFactor{name='" + name + "', riskMultiplier=" + riskMultiplier + "}";
    }
}

// Class to represent Schizophrenia Risk Calculation
public class SchizophreniaRisk {
    private List<Gene> genes;
    private List<EnvironmentalFactor> environmentalFactors;

    public SchizophreniaRisk() {
        genes = new ArrayList<>();
        environmentalFactors = new ArrayList<>();
    }

    public void addGene(Gene gene) {
        genes.add(gene);
    }

    public void addEnvironmentalFactor(EnvironmentalFactor factor) {
        environmentalFactors.add(factor);
    }

    public double calculateTotalRisk() {
        double baseRisk = 0.0;

        // Calculate genetic contribution
        for (Gene gene : genes) {
            baseRisk += gene.getRiskFactor();
        }

        // Apply environmental factors
        for (EnvironmentalFactor factor : environmentalFactors) {
            baseRisk *= factor.getRiskMultiplier();
        }

        return baseRisk;
    }

    public static void main(String[] args) {
        SchizophreniaRisk riskModel = new SchizophreniaRisk();

        // Adding some genes with hypothetical risk factors
        riskModel.addGene(new Gene("COMT", 0.2));
        riskModel.addGene(new Gene("DISC1", 0.3));
        riskModel.addGene(new Gene("NRG1", 0.15));

        // Adding environmental factors
        riskModel.addEnvironmentalFactor(new EnvironmentalFactor("Childhood Trauma", 1.5));
        riskModel.addEnvironmentalFactor(new EnvironmentalFactor("Urban Environment", 1.2));

        // Calculate and display total risk
        double totalRisk = riskModel.calculateTotalRisk();
        System.out.println("Total Schizophrenia Risk: " + totalRisk);
    }
}
