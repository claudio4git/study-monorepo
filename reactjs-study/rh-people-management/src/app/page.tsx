import Link from "next/link";

export default function Home() {
  return (
    <div>
      <ul>
        <li><Link href="/people/list">People</Link></li>
      </ul>
    </div>
  )
}
