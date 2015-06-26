package pucrs.alpro3np.graphs;

public class Edge
{
	private String origin;
	private String destination;
	private double weight;
	
	public String getOrigin()
	{
		return origin;
	}
	
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}
	
	public String getDestination()
	{
		return destination;
	}
	
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
	public double getWeight()
	{
		return weight;
	}
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	
	public Boolean contains(String vertice)
	{
		return vertice == origin || vertice == destination;
	}
	
	@Override
	public String toString()
	{
		return "[" + origin + ", " + destination + ", " + weight +"]";
	}
}
